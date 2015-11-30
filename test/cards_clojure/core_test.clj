(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

;test hand
(def hand-1 #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(def hand-2 #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :diamonds
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(deftest flush?-test
  (testing "Flush returns true if the hand is a flush."
    (is (= true flush? hand-1))
    (is (= false flush? hand-2))))
