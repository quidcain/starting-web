(ns starting-web.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.util.response :refer [response]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response
                                          wrap-json-body]])
  (:gen-class))

(defn handler [request]
  (response {:message "Hello World"}))

(def app
  (-> handler
      wrap-json-body
      wrap-json-response))

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

