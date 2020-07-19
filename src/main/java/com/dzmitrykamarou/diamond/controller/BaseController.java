package com.dzmitrykamarou.diamond.controller;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

  protected static final String API_ENDPOINT = "/api";
  protected static final String API_VERSION = "/v1";
  Map<String, Object> responseBody = new HashMap<>();
}
