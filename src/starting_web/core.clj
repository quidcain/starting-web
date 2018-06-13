(ns starting-web.core
  (:use [ring.adapter.jetty]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})


;;(defonce server (run-jetty handler {:port 3000}))
