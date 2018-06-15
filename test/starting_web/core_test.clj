(ns starting-web.core-test
  (:require [clojure.test :refer :all]
            [starting-web.core :refer :all]
            [ring.mock.request :as mock]
            [cheshire.core :refer [generate-string]]))

(deftest app-test
  (is (= (app (mock/request :get "/"))
         {:status 200
          :headers {"Content-Type" "application/json; charset=utf-8"}
          :body  (generate-string {:message "Hello World"})})))
