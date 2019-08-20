package com.huobi.client.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.huobi.client.model.Candlestick;
import com.huobi.client.model.enums.CandlestickInterval;

/**
 * The candlestick/kline data received by subscription of candlestick/kline.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CandlestickMessage {

  /**
   * the symbol you subscribed. like "btcusdt".
   */
  private String symbol;
  /**
   * Get the UNIX formatted timestamp generated by server in UTC.
   */
  private long timestamp;
  /**
   * Get candlestick/kline interval you subscribed. see {@link CandlestickInterval}
   */
  private CandlestickInterval interval;

  /**
   * Get the data of candlestick/kline see {@link Candlestick}
   */
  private Candlestick data;
}

