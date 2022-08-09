(ns patients.app)

(require '[ring.adapter.jetty :refer [run-jetty]])
(require '[compojure.core :refer [GET ANY defroutes]])

(defn page-index [request]
  {:status 200
   :headers {"content-type" "text/plain"}
   :body "Application for Health Samurai!"})

(defn page-404 [request]
  {:status 404
   :headers {"content-type" "text/plain"}
   :body "Page not found."})

(defroutes app
  (GET "/"      request (page-index request))
  (ANY "/ping" _ {:status 200 :body "pong"})
  page-404)

(run-jetty app {:port 8080 :join? true})
