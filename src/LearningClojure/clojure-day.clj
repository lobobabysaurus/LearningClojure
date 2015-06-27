(def feet 5)
(def inches 11)
(def feet-and-inches (+ (* 5 12) 11))
(def cm (* feet 2.54))
(def inches (* cm 2.54))
(def feet (quot inches 12))
(def inches (mod feet 12))

(def test-vect [3 2 1])
(vector? test-vect)
(conj test-vect 45)
(def conjed-vect (conj test-vect 45))
(count conjed-vect)
(nth conjed-vect 0)
(nth conjed-vect 3)
(first conjed-vect)
(rest conjed-vect)

(def temps [71 79 82 87 87 91 20])
(nth temps 3)

(defn total-pa-bill [subtotal]
  (* subtotal 1.08))

(defn total-with-tip [subtotal percent]
  (double (* (total-pa-bill subtotal) (+ 1 (/ percent 100)))))

(defn share-per-person [subtotal percent people]
  (/ (total-with-tip subtotal percent) people))
(share-per-person 100 10 4)

(def dine-in [6.1 14.2 66.6])
(def dine-out [5.4 3.2 4.5])

(map total-pa-bill dine-in )
(map total-pa-bill dine-out )

(reduce + dine-in)
(reduce max dine-out)

(defn average [bills]
  (/ (reduce + bills) (count bills)))

(def my-hometown "Newtwown Square")

(defn format-name [first last]
  (str first " " last))

(def my-name (format-name  "Philip" "Simmons"))
(= my-name "Philip Simmons")

(defn triple-values [list]
  (map
    (fn [x]
      (* x 3))
    list))

(triple-values dine-in)

(defn product [list]
  (reduce
    (fn [total next]
      (* total next))
    list))

(product dine-out)

(def address {:number 1514 :street "Green St" :city "Philadephia" :state "PA" :zip 19130})
(def empty-map {})
(map? address)
(map? empty-map)

(def country-address (assoc address :country "United States"))
(def no-num (dissoc address :number))
(merge no-num {:number 44 :zip 44})

(get no-num :address)
(get no-num :city)
(get no-num :continent :NOOO)

(count no-num)

(keys no-num)
(vals no-num)
(:street no-num)

(def maps-vector [no-num country-address])

(def my-name {:first "Phil" :last "Simmons"})

(def me-info [my-name address])

(defn expand-name [name-map]
  (str (:first name-map) " " (:last name-map)))

(defn names-enumerate [vector-of-maps]
  (into [] (map expand-name vector-of-maps)))

(names-enumerate [{:first "Margaret" :last "Atwood"}
                  {:first "Doris" :last "Lessing"}
                  {:first "Ursula" :last "Le Guin"}
                  {:first "Alice" :last "Munro"}])

(defn awesome? [name]
  (if (= name "Philip Simmons")
    "You're awesome"
    "You're not as awesome as you could be"))
(awesome? "Philip Simmons")
(awesome? "Lobotomy Johnson")

(defn three-name-format [name-map order]
  (if (not (= order :last))
    (if (:middle name-map)
      (str (:first name-map) " "
        (:middle name-map) " "
        (:last name-map))
      (str (:first name-map) " "
        (:last name-map)))
    (if (:middle name-map)
      (str (:last name-map) ", "
        (:first name-map) " "
        (:middle name-map))
      (str (:last name-map) " "
        (:first name-map)))))

(def name-map {:first "Philip" :last "Simmons"})
(def full-name (assoc name-map :middle "Ryan"))

(three-name-format name-map :first)
(three-name-format full-name :last)

(defn leap_year? [year]
  (and (zero? (mod year 4))
    (or (zero? (mod year 400))
      (not (zero? (mod year 100))))))

(leap_year? 1996)
(leap_year? 1900)
(leap_year? 2000)

(defn range [numbers]
  (let [largest (reduce max numbers)
        smallest (reduce min numbers)]
    (- largest smallest)))

(def range-nums [0 5 10 15 20])

(range range-nums)

(defn let-average [numbers]
  (let [total (reduce + numbers)
        count (count numbers)]
    (/ total count)))

(let-average range-nums)

(defn ordinal [number]
  (def moddy (mod number 10))
  (cond
    (= (quot number 10) 1) (str number "th")
    (= moddy 1) (str number "st")
    (= moddy 2) (str number "nd")
    (= moddy 3) (str number "rd")
    :else (str number "th")))

(ordinal 21)
(ordinal 32)
(ordinal 43)
(ordinal 56)

(ordinal 11)
(ordinal 12)
(ordinal 13)
(ordinal 16)