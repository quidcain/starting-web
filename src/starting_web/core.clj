(ns starting-web.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:require [ring.middleware.reload :refer [wrap-reload]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(def app
  (wrap-reload handler))

;; Usefull commands to run server from REPL
;; 
;;(def server (run-jetty #'app {:port 3000 :join? false}))
;;(.start server)
;;(.stop server)
