package br.com.itau.negotiationservice.logging;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Objects;

public class LogFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        final var nanoStartTime = System.nanoTime();
        final var contextMap = new HashMap<>();
        final var httpServletRequest = exchange.getRequest();

        HttpHeaders headers = httpServletRequest.getHeaders();
        contextMap.put(MdcConstants.REQUEST_METHOD, Objects.requireNonNull(httpServletRequest.getMethod()).name());
        contextMap.put(MdcConstants.REQUEST_URI, httpServletRequest.getURI().toString());
        contextMap.put(MdcConstants.REQUEST_PATH, httpServletRequest.getURI().getPath());
        contextMap.put(MdcConstants.REQUEST_HOST, httpServletRequest.getURI().getHost());
        contextMap.put(MdcConstants.REQUEST_HEADERS, httpServletRequest.getHeaders().toString());
        contextMap.put(MdcConstants.REQUEST_QUERY, httpServletRequest.getQueryParams().toString());
        contextMap.put(MdcConstants.HOST, httpServletRequest.getURI().getHost());
        contextMap.put(MdcConstants.PORT, String.valueOf(httpServletRequest.getURI().getPort()));
        contextMap.put("nanoStartTime", String.valueOf(nanoStartTime));

        return chain
                .filter(exchange)
                .contextWrite(Context.of(contextMap));
    }

}
