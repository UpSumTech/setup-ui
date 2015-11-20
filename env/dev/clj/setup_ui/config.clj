(ns setup-ui.config
  (:require [selmer.parser :as parser]
            [taoensso.timbre :as timbre]
            [setup-ui.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (timbre/info "\n-=[setup-ui started successfully using the development profile]=-"))
   :middleware wrap-dev})
