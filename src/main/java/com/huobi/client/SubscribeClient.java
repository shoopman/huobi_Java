package com.huobi.client;

import com.huobi.client.enums.BalanceMode;
import com.huobi.client.impl.HuobiApiInternalFactory;
import com.huobi.client.message.AggrTradesMessage;
import com.huobi.client.message.CandlestickMessage;
import com.huobi.client.message.PriceDepthMessage;
import com.huobi.client.message.TradeMessage;
import com.huobi.client.message.TradeOverviewMessage;
import com.huobi.client.message.TradeSummaryMessage;
import com.huobi.gateway.enums.CandlestickIntervalEnum;

/***
 * The subscription client interface, it is used for subscribing any market data update and
 * account change, it is asynchronous, so you must implement the SubscriptionListener interface.
 * The server will push any update to the client. if client get the update, the onReceive method
 * will be called.
 */
public interface SubscribeClient {

  /**
   * Subscribe candlestick/kline event. If the candlestick/kline is updated, server will send the data to client and onReceive in callback will be
   * called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param interval The candlestick/kline interval, MIN1, MIN5, DAY1 etc.
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   */
  void subscribeCandlestick(String symbols, CandlestickIntervalEnum interval,
      SubscriptionListener<CandlestickMessage> callback);

  /**
   * Subscribe candlestick/kline event. If the candlestick/kline is updated, server will send the data to client and onReceive in callback will be
   * called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param interval The candlestick/kline interval, MIN1, MIN5, DAY1 etc.
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   * @param errorHandler The error handler will be called if subscription failed or error happen between client and Huobi server.
   */
  void subscribeCandlestick(String symbols, CandlestickIntervalEnum interval,
      SubscriptionListener<CandlestickMessage> callback,
      SubscriptionErrorHandler errorHandler);

  /**
   * Subscribe price depth event. If the price depth is updated, server will send the data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   */
  void subscribePriceDepth(String symbols, SubscriptionListener<PriceDepthMessage> callback);

  /**
   * Subscribe price depth event. If the price depth is updated, server will send the data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   * @param errorHandler The error handler will be called if subscription failed or error happen between client and Huobi server.
   */
  void subscribePriceDepth(String symbols,
      SubscriptionListener<PriceDepthMessage> callback,
      SubscriptionErrorHandler errorHandler);

  /**
   * Subscribe price depth event. If the price depth is updated server will send the data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   */
  void subscribeTradeEvent(String symbols, SubscriptionListener<TradeMessage> callback);

  /**
   * Subscribe price depth event. If the price depth is updated, server will send the data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's update.
   * @param errorHandler The error handler will be called if subscription failed or error happen between client and Huobi server.
   */
  void subscribeTradeEvent(String symbols,
      SubscriptionListener<TradeMessage> callback,
      SubscriptionErrorHandler errorHandler);

  void subscribeAggrTradesEvent(String symbols, SubscriptionListener<AggrTradesMessage> callback);

  void subscribeAggrTradesEvent(String symbols, SubscriptionListener<AggrTradesMessage> callback,
      SubscriptionErrorHandler errorHandler);


  void subscribeTradeSummaryEvent(String symbols, SubscriptionListener<TradeSummaryMessage> callback);

  void subscribeTradeSummaryEvent(String symbols, SubscriptionListener<TradeSummaryMessage> callback,
      SubscriptionErrorHandler errorHandler);

  void subscribeTradeOverviewEvent(SubscriptionListener<TradeOverviewMessage> callback);

  void subscribeTradeOverviewEvent(SubscriptionListener<TradeOverviewMessage> callback,
      SubscriptionErrorHandler errorHandler);

  void requestCandlestickEvent(String symbols, Long from, Long to,
      CandlestickIntervalEnum interval,
      SubscriptionListener<CandlestickMessage> callback);

  void requestCandlestickEvent(String symbols, Long from, Long to,
      CandlestickIntervalEnum interval,
      SubscriptionListener<CandlestickMessage> callback,
      SubscriptionErrorHandler errorHandler);
  /**
   * Subscribe account changing event. If the balance is updated, server will send the data to
   * client and onReceive in callback will be called. default to subscribe the available balance.
   *
   * @param mode The account balance mode, see {@link BalanceMode}
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   */
//  void subscribeAccountEvent(BalanceMode mode, SubscriptionListener<AccountEvent> callback);

  /**
   * Subscribe account changing event. If the balance is updated, server will send the data to
   * client and onReceive in callback will be called.
   *
   * @param mode when mode is AVAILABLE, balance refers to available balance; when mode is TOTAL,
   * balance refers to TOTAL balance for trade sub account (available+frozen).
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   * @param errorHandler The error handler will be called if subscription failed or error happen
   * between client and Huobi server.
   */
//  void subscribeAccountEvent(BalanceMode mode, SubscriptionListener<AccountEvent> callback,
//      SubscriptionErrorHandler errorHandler);

  /**
   * Subscribe order changing event. If a order is created, canceled etc, server will send the data
   * to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like
   * "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   */
//  void subscribeOrderUpdateEvent(String symbols, SubscriptionListener<OrderUpdateEvent> callback);

  /**
   * Subscribe order changing event. If a order is created, canceled etc, server will send the data
   * to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like
   * "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   * @param errorHandler The error handler will be called if subscription failed or error happen
   * between client and Huobi server.
   */
//  void subscribeOrderUpdateEvent(String symbols, SubscriptionListener<OrderUpdateEvent> callback,
//      SubscriptionErrorHandler errorHandler);

  /**
   * Subscribe 24 hours trade statistics event. If statistics is generated, server will send the
   * data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like
   * "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   */
//  void subscribe24HTradeStatisticsEvent(String symbols,
//      SubscriptionListener<TradeStatisticsEvent> callback);

  /**
   * Subscribe 24 hours trade statistics event. If statistics is generated, server will send the
   * data to client and onReceive in callback will be called.
   *
   * @param symbols The symbols, like "btcusdt". Use comma to separate multi symbols, like
   * "btcusdt,ethusdt".
   * @param callback The implementation is required. onReceive will be called if receive server's
   * update.
   * @param errorHandler The error handler will be called if subscription failed or error happen
   * between client and Huobi server.
   */
//  void subscribe24HTradeStatisticsEvent(String symbols,
//      SubscriptionListener<TradeStatisticsEvent> callback, SubscriptionErrorHandler errorHandler);

  /**
   * Unsubscribe all subscription.
   */
  void unsubscribeAll();

  /**
   * Create the subscription client to subscribe the update from server.
   *
   * @return The instance of synchronous client.
   */
  static SubscribeClient create() {
    return create("", "", new SubscribeOption());
  }

  /**
   * Create the subscription client to subscribe the update from server.
   *
   * @param apiKey The public key applied from Huobi.
   * @param secretKey The private key applied from Huobi.
   * @return The instance of synchronous client.
   */
  static SubscribeClient create(
      String apiKey, String secretKey) {
    return HuobiApiInternalFactory.getInstance().createSubscribeClient(
        apiKey, secretKey, new SubscribeOption());
  }

  /**
   * Create the subscription client to subscribe the update from server.
   *
   * @param apiKey The public key applied from Huobi.
   * @param secretKey The private key applied from Huobi.
   * @param subscribeOption The option of subscription connection, see {@link SubscriptionOptions}
   * @return The instance of synchronous client.
   */
  static SubscribeClient create(
      String apiKey, String secretKey, SubscribeOption subscribeOption) {
    return HuobiApiInternalFactory.getInstance().createSubscribeClient(
        apiKey, secretKey, subscribeOption);
  }

}