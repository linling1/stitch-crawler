package com.linling.stitch.crawler.common;

import lombok.Data;
import lombok.Getter;

@Data
public class FetchStatus {

    private FetchCode fetchCode;
    private String msg;

    public static FetchStatus of(FetchCode fetchCode, String msg) {
        FetchStatus fetchStatus = new FetchStatus();
        fetchStatus.setFetchCode(fetchCode);
        fetchStatus.setMsg(msg);
        return fetchStatus;
    }

    public static FetchStatus of(FetchCode fetchCode) {
        return of(fetchCode, null);
    }

    public static enum FetchCode {
        UNFETCHED(0),       // Page was not fetched yet
        SUCCESS(1),         // Page was successfully fetched
        IO_ERROR(2),        // I/O error
        FETCHED_ERROR(3),     // Unspecified error occured. Further information may be provided in args.
        TIMEOUT_ERROR(4),  // Timeout error
        ILLEGAL_ARGUMENT_ERROR(5);     // Illegal argument error

        @Getter
        private int code;

        private FetchCode(int code) {
            this.code = code;
        }
    }

}
