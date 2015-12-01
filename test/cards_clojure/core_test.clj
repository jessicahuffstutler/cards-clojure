(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

;test hand
(def hand-1 #{{:suit :clubs                                 ;flush
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(def hand-2 #{{:suit :clubs                                 ;not a flush
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :diamonds
               :rank :queen}
              {:suit :clubs
               :rank :king}})

(def hand-3 #{{:suit :clubs                                 ;straight-flush
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank 4}
              {:suit :clubs
               :rank 5}})

(def hand-4 #{{:suit :clubs                                 ;straight
               :rank 2}
              {:suit :diamonds
               :rank 3}
              {:suit :hearts
               :rank 4}
              {:suit :spades
               :rank 5}})

(def hand-5 #{{:suit :clubs                                 ;4 of a kind
               :rank 2}
              {:suit :diamonds
               :rank 2}
              {:suit :hearts
               :rank 2}
              {:suit :spades
               :rank 2}})

(def hand-6 #{{:suit :clubs                                 ;3 of a kind
               :rank 2}
              {:suit :diamonds
               :rank 2}
              {:suit :hearts
               :rank 2}
              {:suit :spades
               :rank 5}})

(def hand-7 #{{:suit :clubs                                 ;two pair
               :rank 2}
              {:suit :diamonds
               :rank 2}
              {:suit :hearts
               :rank 4}
              {:suit :spades
               :rank 4}})

(deftest flush?-test
  (testing "Flush returns true if the hand is a flush."
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))

(deftest straight-flush?-test
  (testing "Straight-flush returns true if the hand is a straight-flush."
    (is (= false (straight-flush? hand-5)))                 ;doesn't work on the keywords (i.e. hand-1)
    (is (= true (straight-flush? hand-3)))))

(deftest straight?-test
  (testing "Straight returns true if the hand is a straight."
    (is (= false (straight? hand-5)))                       ;doesn't work on the keywords (i.e. hand-1)
    (is (= true (straight? hand-4)))))

(deftest four-of-a-kind?-test
  (testing "four-of-a-kind returns true if the hand is a four-of-a-kind."
    (is (= false (four-of-a-kind? hand-1)))
    (is (= true (four-of-a-kind? hand-5)))))

(deftest three-of-a-kind?-test
  (testing "three-of-a-kind returns true if the hand is a three-of-a-kind."
    (is (= false (three-of-a-kind? hand-1)))
    (is (= true (three-of-a-kind? hand-6)))))

(deftest two-pair?-test
  (testing "two-pair returns true if the hand is a two-pair."
    (is (= false (two-pair? hand-1)))
    (is (= true (two-pair? hand-7)))))