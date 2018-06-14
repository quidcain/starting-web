(ns starting-web.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:require [ring.util.response :refer [response]])
  (:require [ring.middleware.reload :refer [wrap-reload]])
  (:require [ring.middleware.json :refer [wrap-json-response]])
  (:gen-class))

(defn handler [request]
  (response {:message "Hello World"}))

(def app
  (wrap-json-response handler))

(def reloadable-app
  (wrap-reload app))

(defn create-start-server []
  (run-jetty #'reloadable-app {:port 3000 :join? false}))

(defn -main [& args]
  (create-start-server))

;; Usefull commands to run server from REPL
;; 
;;(def server (create-start-server))
;;(.start server)
;;(.stop server)
