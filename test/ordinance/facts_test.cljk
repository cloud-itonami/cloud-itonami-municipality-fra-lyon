(ns ordinance.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest lyon-has-spec-basis
  (let [sb (facts/spec-basis "lyon")]
    (is (= 2 (count sb)))
    (is (every? #(str/includes? (:ordinance/url %) "lyon.fr") sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "marseille")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["lyon" "marseille"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["marseille"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["lyon.deliberation-2021-1164-logements-sociaux"]
         (mapv :ordinance/id (facts/by-topic "lyon" :housing))))
  (is (empty? (facts/by-topic "lyon" :labor)))
  (is (empty? (facts/by-topic "marseille" :governance))))
