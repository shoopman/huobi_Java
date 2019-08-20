package com.huobi.gateway;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SideEnum {

  /**
   * 买
   */
  BUY(0),
  /**
   * 卖
   */
  SELL(1);

  public final int code;

  public static SideEnum getByCode(int code) {
    for (SideEnum side : SideEnum.values()) {
      if (side.code == code) {
        return side;
      }
    }

    return null;
  }
}

