Feature: Pet API Tests

  Scenario Template: send to request with "<method>" for pet api
    * Set to request body for store "<requestBody>" string
    * Send to "<domain>" "<url>" "<status>" "<id>" request with "<method>" for pet api
    * Assert to status code <code>

    Examples: send to request with for pet api
      | domain     | url                 | status    | id | method | code | requestBody                                  |
      | DOMAIN_URL | PET_FIND_STATUS     | sold      |    | GET    | 200  |                                              |
      | DOMAIN_URL | PET_FIND_STATUS     | available |    | GET    | 200  |                                              |
      | DOMAIN_URL | PET_FIND_STATUS     | pending   |    | GET    | 200  |                                              |
      | DOMAIN_URL | PET_URL             |           | 1  | post   | 200  | 'petId':1,\n'name':'Kitty',\n'status':'sold' |
      | DOMAIN_URL | STORE_ORDER_URL     |           | 1  | DEL    | 200  | 'orderId':1                                  |
      | DOMAIN_URL | STORE_INVENTORY_URL |           |    | GET    | 200  |                                              |