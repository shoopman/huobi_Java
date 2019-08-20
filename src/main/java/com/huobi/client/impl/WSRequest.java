package com.huobi.client.impl;

import com.huobi.client.SubscriptionErrorHandler;
import com.huobi.client.SubscriptionListener;
import com.huobi.client.impl.utils.Handler;

public class WSRequest<T> {
  String name;
  Handler<WSConnection> connectionHandler;
  Handler<WSConnection> authHandler = null;
  final SubscriptionListener<T> updateCallback;
  RestApiJsonParser<T> jsonParser;
  final SubscriptionErrorHandler errorHandler;

  public WSRequest(SubscriptionListener<T> listener, SubscriptionErrorHandler errorHandler) {
    this.updateCallback = listener;
    this.errorHandler = errorHandler;
  }
}
