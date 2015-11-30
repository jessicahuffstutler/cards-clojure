(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])              ;clojure keywords, not strings; single words that act as identifiers

(def ranks (range 1 14))                                    ;range is exclusive, so it will stop at the one before the end number; i.e. 13 here.

(def rank-names {1  :ace
                 11 :jack
                 12 :queen
                 13 :king})

(defn create-deck []
  (set (for [suit suits
             rank ranks]
         {:suit suit
          :rank {get rank-names rank rank}})))              ;rank is here twice, says look inside rank names for rank, if it doesnt exist, just show rank

(defn create-hands [deck]
  (set (for [c1 deck
             c2 (disj deck c1)                              ;removes c1 from the deck so we dont get the same exact card again in our hand
             c3 (disj deck c1 c2)
             c4 (disj deck c1 c2 c3)]
         #{c1 c2 c3 c4})))

(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))

(defn -main [& args]
  (time (let [deck (create-deck)                            ;time tells us how much time elapsed while getting the 2860 answer.
              hands (create-hands deck)
              hands (filter flush? hands)]
          (println (count hands)))))
