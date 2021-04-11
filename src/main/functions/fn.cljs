(ns functions.fn
  (:require ["firebase-functions" :as functions]
            ["firebase-admin" :as admin]))

(defonce init (.initializeApp admin))

(defn log
  "Log cljs data arguments to functions logger"
  [& args]
  (apply (.-log functions/logger) (map clj->js args)))

(defn echo
  "Echo the passed in query parameters merged with the current time"
  [req res]
  (let [query (js->clj (.-query req) :keywordize-keys true)]
    (log "hello" query)
    (.json res (clj->js {:time (.toString (js/Date.))
                         :query query}))))

(def exports
  #js {:echo (.onRequest functions/https echo)})

