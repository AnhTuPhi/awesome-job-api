package vn.com.tech.awesome.job.api.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Admin
 * @created 18/01/2024 - 11:33 AM
 * @project awesome-job-api
 */
public abstract class CommonProcessor<S, QE, T> {

    protected final Logger log;

    protected final QE Q;

    protected final S service;
    protected final T transformer;

    protected CommonProcessor(QE Q, S service, T transformer) {
        log = LoggerFactory.getLogger(getClass());

        this.Q = Q;
        this.service = service;
        this.transformer = transformer;
    }
}