(ns starting-web.core-test
  (:require [clojure.test :refer :all]
            [starting-web.core :refer :all]
            [ring.mock.request :as mock]
            [cheshire.core :refer [parse-string]]
            [clojure.string :refer [starts-with?]]))

(deftest get-products-test
  (let [response (app (mock/request :get "/products"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "GET products"}))))

(deftest post-product-test
  (let [response (app (mock/request :post "/products"))]
    (is (= (:status response) 201))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "POST products"}))))

(deftest get-product-test
  (let [response (app (mock/request :get "/products/1"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "GET product 1"}))))

(deftest put-product-test
  (let [response (app (mock/request :put "/products/1"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "PUT product 1"}))))

(deftest delete-product-test
  (let [response (app (mock/request :delete "/products/1"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "DELETE product 1"}))))


(deftest get-orders-test
  (let [response (app (mock/request :get "/orders"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "GET orders"}))))

(deftest post-order-test
  (let [response (app (mock/request :post "/orders"))]
    (is (= (:status response) 201))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "POST order"}))))

(deftest get-order-test
  (let [response (app (mock/request :get "/orders/1"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "GET order 1"}))))

(deftest delete-order-test
  (let [response (app (mock/request :delete "/orders/1"))]
    (is (= (:status response) 200))
    (is (starts-with?
         (get-in response [:headers "Content-Type"])
         "application/json"))
    (is (=
         (parse-string (:body response))
         {"message" "DELETE order 1"}))))

(deftest unknown-route-test
    (let [response (app (mock/request :get "/weird-route"))]
      (is (= (:status response) 404))))
