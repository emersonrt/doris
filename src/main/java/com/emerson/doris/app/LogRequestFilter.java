//package com.emerson.doris.app;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//
//@Component
//public class LogRequestFilter implements Filter {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
//                         FilterChain filterChain) throws IOException, ServletException {
//        logPostOrPutRequestBody((HttpServletRequest) servletRequest);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    private void logPostOrPutRequestBody(HttpServletRequest httpRequest) throws IOException {
//        if(Arrays.asList("POST", "PUT").contains(httpRequest.getMethod())) {
//            String characterEncoding = httpRequest.getCharacterEncoding();
//            Charset charset = Charset.forName(characterEncoding);
//            String bodyInStringFormat = readInputStreamInStringFormat(httpRequest.getInputStream(), charset);
//            log.info("Request body: {}", bodyInStringFormat);
//        }
//    }
//
//    private String readInputStreamInStringFormat(InputStream stream, Charset charset) throws IOException {
//        final int MAX_BODY_SIZE = 1024;
//        final StringBuilder bodyStringBuilder = new StringBuilder();
//        if (!stream.markSupported()) {
//            stream = new BufferedInputStream(stream);
//        }
//
//        stream.mark(MAX_BODY_SIZE + 1);
//        final byte[] entity = new byte[MAX_BODY_SIZE + 1];
//        final int bytesRead = stream.read(entity);
//
//        if (bytesRead != -1) {
//            bodyStringBuilder.append(new String(entity, 0, Math.min(bytesRead, MAX_BODY_SIZE), charset));
//            if (bytesRead > MAX_BODY_SIZE) {
//                bodyStringBuilder.append("...");
//            }
//        }
//        stream.reset();
//
//        return bodyStringBuilder.toString();
//    }
//
//}
