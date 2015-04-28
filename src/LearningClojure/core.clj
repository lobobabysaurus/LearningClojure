(ns LearningClojure.core)
(require '[clojure.string :as string])

;Checks if the argument is in the set of variable characters
(def vowel? (set "aeiou"))

;Takes a word and converts it to pig latin
(defn pig-latin [word]
  ;For the first let of a word
  (let [first-letter (first word)]
    ;if it is a vowel
    (if (vowel? first-letter)
      ;return the word with ay at the back
      (str word "ay")
      ; return the word minus the last letter, the first letter and then ay
      (str (subs word 1) first-letter "ay"))))

(println (string/capitalize (pig-latin "red")))
(println (string/capitalize (pig-latin "orange")))
