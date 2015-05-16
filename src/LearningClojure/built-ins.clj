(require '[clojure.string :as string])
(def testmap
  (hash-map :green :blue))
(println  (testmap :green))

(def stooges (vector "Test" "Test2"))
(println (stooges 0))
(println (count stooges))
(def rev_stooges (reverse stooges) )
(println rev_stooges)
;(println (rev_stooges 0))
(println (first stooges))
(println (last stooges))
(println (map string/upper-case stooges))