(ns starting-web.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:require [ring.middleware.reload :refer [wrap-reload]])
  (:gen-class))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})

(def app
  (wrap-reload handler))

(defn create-start-server []
  (run-jetty #'app {:port 3000 :join? false}))

(defn -main [& args]
  (create-start-server))

;; Usefull commands to run server from REPL
;; 
;;(def server (create-start-server))
;;(.start server)
;;(.stop server)
