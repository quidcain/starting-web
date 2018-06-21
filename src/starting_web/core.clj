(ns starting-web.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.util.response :refer [response
                                        status]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.json :refer [wrap-json-response
                                          wrap-json-body]]
            [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route])
  (:gen-class))

(defn handler [request]
  (response {:message "Hello World" :uri (:uri request)}))

(defroutes app-routes
  (context "/products" [] (defroutes products-routes
    (GET "/" []  (response {:message "GET products"}))
    (POST "/" [] (status (response {:message "POST products"}) 201)))
    (context "/:id" [id] (defroutes product-routes
      (GET "/" [] (response {:message (str "GET product " id)}))
      (PUT "/" [] (response {:message (str "PUT product " id)}))
      (DELETE "/" [] (response {:message (str "DELETE product " id)})))))
  (context "/orders" [] (defroutes orders-routes
    (GET "/" [] (response {:message "GET orders"}))
    (POST "/" [] (status (response {:message "POST order"}) 201)))
    (context "/:id" [id] (defroutes order-routes
      (GET "/" [] (response {:message (str "GET order " id)}))
      (DELETE "/" [] (response {:message (str "DELETE order " id)})))))
  (route/not-found (response {:message "Not found"})))

(def app
  (-> app-routes
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

