(ns setup-ui.routes.home
  (:require [setup-ui.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [ok]]
            [ring.util.response :refer [redirect]]
            [setup-ui.db.core :as db]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [clojure.java.io :as io]))

(defn validate-node [params]
  (first
    (b/validate
      params
      :name [v/required v/string]
      :description [v/required v/string])))

(defn home-page [{:keys [flash]}]
  (layout/render
    "home.html"
    (merge {:nodes (db/get-nodes)}
           (select-keys flash [:name :description :errors]))))

(defn create-node! [{:keys [params]}]
  (if-let [errors (validate-node params)]
    (-> (redirect "/")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/create-node!
        (assoc params :timestamp (java.util.Date.)))
      (redirect "/"))))

(defroutes home-routes
  (GET "/" request (home-page request))
  (POST "/" request (create-node! request)))
