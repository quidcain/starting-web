(ns starting-web.core-test
  (:require [clojure.test :refer :all]
            [starting-web.core :refer :all]))

(deftest a-test
  (testing "Should return response with 200 code"
    (is (= {:status 200
            :headers {"Content-Type" "text/html"}
            :body "Hello World"}
           (handler {})))))
