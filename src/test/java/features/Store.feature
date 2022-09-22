Feature: Store API Tests

  Scenario Outline: send to request with "<method>" for store api
    * Send to "<domain>" "<url>" "<id>" request with "<method>" for store api
    * Assert to status code <code>
    Scenarios: send to request with for store api
      | domain           | url             | id | method | code |
      | STORE_DOMAIN_URL | STORE_ORDER_URL | 5  | GET    | 200  |
      | STORE_DOMAIN_URL | STORE_ORDER_URL |    | POST    | 200   |








