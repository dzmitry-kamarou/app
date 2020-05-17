package com.dzmitrykamarou.diamond.controller;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

  protected static final String API = "/api";
  protected static final String V1 = "/v1";
  Map<String, Object> responseBody = new HashMap<>();
}
