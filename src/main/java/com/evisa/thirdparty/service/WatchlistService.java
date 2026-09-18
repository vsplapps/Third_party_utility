package com.evisa.thirdparty.service;

import com.evisa.thirdparty.dto.request.WatchlistCheckRequest;
import com.evisa.thirdparty.dto.response.WatchlistCheckResponse;

public interface WatchlistService {

    WatchlistCheckResponse check(WatchlistCheckRequest request);
}
