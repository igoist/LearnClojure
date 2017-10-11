(ns)

; Diff between reduce & map
(reduce max [0 -3 10 48])            ; 48

(map max [0 -3 10 48] [1 2 3 4])     ; (1 2 10 48)

(reduce
 (fn [m v]
   (assoc m v (* v v)))
 {}
 [1 2 3 4])                          ; {1 1, 2 4, 3 9, 4 16}

(reduce
  #(assoc % %2 (* %2 %2))
  {}
  [1 2 3 4])                         ; the same as above

(map
 (fn [m v]
   (assoc m v (* v v)))
 {}
 [1 2 3 4])                          ; ()


; What's partial?
(def only-strings (partial filter string?))

(only-strings ["a" 5 "b" 6])         ; ("a" "b")

(#(filter string? %) ["a" 5 "b" 6])  ; same

(#(filter % ["a" 5 "b" 6]) string?)  ; same

(#(filter % ["a" 5 "b" 6]) number?)  ; same


(#(map *) [1 2 3] [4 5 6])           ; !error

((partial map *) [1 2 3] [4 5 6] [7 8 9])    ; (28 80 162)


; comp
(def negated-sum-str (comp str - +))

(negated-sum-str 10 12 3.4)          ; -25.4

(require '[clojure.string :as str])

(def camel->keyword (comp keyword
                          str/join
                          (partial interpose \-)
                          (partial map str/lower-case)
                          #(str/split % #"(?<=[a-z])(?=[A-Z])")))

(camel->keyword "CamelCase")          ; :camel-case

(defn camel->keyword2
  [s]
  (->> (str/split s #"(?<=[a-z])(?=[A-Z])")
       (map str/lower-case)
       (interpose \-)
       str/join
       keyword))

(camel->keyword2 "CamelCase")

(defn camel->keyword3
  [s]
  (-> keyword
      str/join
      (interpose \-)
      (map str/lower-case)
      (str/split s #"(?<=[a-z])(?=[A-Z])")))

(camel->keyword3 "CamelCase")

(* 8 8 8)

(defn print-logger
  [writer]
  #(binding [*out* writer]
     (println %)))

(def *out*-logger (print-logger *out*))

(*out*-logger "Hello")

