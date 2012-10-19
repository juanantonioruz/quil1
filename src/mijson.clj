(ns mijson
  (:use [clojure.java.io] [midje.sweet])
  (:require [clj-http.client :as client] [cheshire.core :as json])
  )

(def miurl "http://elections.huffingtonpost.com/pollster/api/polls.json?page=2")

(defn parsea-ejemplo []
  (json/decode (:body (client/get miurl)) true) )

(defn first-keys []
  (keys  (first (parsea-ejemplo))))

(defn walk-map-key-class
  "" []
(let [datos (first-json)]
        (map #(class (datos %) ) (keys datos)))
  )

(defn first-json []
  (first (parsea-ejemplo)))

(defn dame-valor-ejemplo
  "probar con :method"
  [clave]
  ((first (parsea-ejemplo)) clave))

(defn obten-valor [x]
        (x "method"))


(defn genera-obten-valor [clave]
  (fn [x] (x clave)))

(def metodolea (genera-obten-valor :method))

(defn pinta-ejemplo []
  (map (genera-obten-valor :sponsors) (parsea-ejemplo))
  )

(fact (dame-valor-ejemplo :method)=>"apache")