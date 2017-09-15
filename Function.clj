(defn f1 [x y]
    (* x y))

(println (f1 2 3))

(f1 3 8)

(def f2 (fn [x y]
         (+ x y)))

(f2 3 5)

(print (f2 3 8))

(+ 1 2)

(defn f3 [name]
  (str "Hello~!" name))

(f3 "igoist")


(defn greet  [name]  (str "Hello, " name))
(greet "students")

(doc +)

(dir clojure.repl)

(/ (+ 7 (* 3 4) 5) 10)

; Multi-arity function
(defn messenger
  ([]    (messenger "Hello world!"))
  ([msg] (println msg)))


; Variadic function
(defn hello [greeting & who]
  (println greeting who))

(hello "Hello" "world" "another")

; def vs fn

(defn greet [name] (str "Hello, " name))

(def greet (fn [name] (str "Hello, " name)))

; Anonymous function
((fn [x y] (+ x y)) 2 3)

(#(+ 2 %1 %2) 1 2 3)

(#(print %1 %2 %&) 1 2 3 4 5)

; Gotcha ?
((fn [x] [x]) 2)

(#(vector %) 2222)

; Applying function
(defn applyTest
  ([a] (println "One"))
  ([a b] (println "Two"))
  ([a b c] (println "Three"))
  ([a b c & x] (println "Four")))

(apply applyTest '("a" "b" "c" "d"))
(apply applyTest "a" '("b" "c" "d"))
(apply applyTest "a" "b" '("c" "d"))
(apply applyTest "a" "b" "c" '("d"))

; Locals and Closures
(let [x 1
      y 2]
  (+ x y))

(defn messenger [msg]
  (let [a 7
        b 5
        c (clojure.string/capitalize msg)]
    (println a b c)))

