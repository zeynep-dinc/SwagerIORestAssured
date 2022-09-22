Feature: Store API Tests

  Scenario Template: send to request with "<method>" for store api
    * Set to request body for store "<requestBody>" string
    * Send to "<domain>" "<url>" "<id>" request with "<method>" for store api
    * Assert to status code <code>

    Examples: send to request with for store api
      | domain           | url                 | id | method | code | requestBody                                                                                                         |
      | STORE_DOMAIN_URL | STORE_ORDER_URL     |    | POST   | 200  | 'id': 1,\n'petId': 0,\n'quantity': 0,\n'shipDate': '2022-09-22T18:27:16.421Z',\n'status':'placed',\n'complete':true |
      | STORE_DOMAIN_URL | STORE_ORDER_URL     | 1  | GET    | 200  | 'orderId':1                                                                                                         |
      | STORE_DOMAIN_URL | STORE_ORDER_URL     | 1  | DEL    | 200  | 'orderId':1                                                                                                         |
      | STORE_DOMAIN_URL | STORE_INVENTORY_URL |    | GET    | 200  |                                                                                                                     |









