(ns setup-ui.config
  (:require [taoensso.timbre :as timbre]))

(def defaults
  {:init
   (fn []
     (timbre/info "\n-=[setup-ui started successfully]=-"))
   :middleware identity})
