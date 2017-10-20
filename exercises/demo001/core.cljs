;; create the main project namespace
(ns modern-cljs.core)

;; enable cljs to print to the JS console of the browser
(enable-console-print!)

(def mouseY 260)

(def Particles '())

;; (.log js/console Particles)

(defn t15->f [n]
  (case n
    0 "0"
    1 "1"
    2 "2"
    3 "3"
    4 "4"
    5 "5"
    6 "6"
    7 "7"
    8 "8"
    9 "9"
    10 "a"
    11 "b"
    12 "c"
    13 "d"
    14 "e"
    15 "f"))

(defn t10->16 [n]
  (str (t15->f (quot n 16)) (t15->f (rem n 16))))

(defn getRandomColor
  []
  (let [r (int (* (rand 1) 255)) g (int (* (rand 1) 255)) b (int (* (rand 1) 255))]
    (do
      ;; (println r g b)
      (str "0x" (t10->16 r) (t10->16 g) (t10->16 b)))))



;; 1. 创建相机，并调整参数 .position.z
(def camera (js/THREE.PerspectiveCamera. 80 (/ js/window.innerWidth js/window.innerHeight) 1 4000))

(def camera.position.z 2)

;; (.log js/console camera.position.z)

;; (.log js/console camera)

;; 2.创建场景，并将相机加入其中
(def scene (js/THREE.Scene.))

;; (.log js/console (.add scene camera))

;; (.log js/console (. scene add camera))

(. scene add camera)

;; 3. CanvasRender
(def renderer (js/THREE.CanvasRenderer.))

(. renderer setSize js/window.innerWidth js/window.innerHeight)

;; (.log js/console renderer)
;; (.log js/console js/document.body.appendChild)
;; (.log js/console renderer.domElement)

;; 4 & 5 body 加入 canvas，创建粒子
(js/document.body.appendChild renderer.domElement)

(defn particleRender
  [context]
  (do
    (. context beginPath)
    (. context arc 0 0 1 0 (* 2 3.14) true)
    (. context fill)))

;; (def o (js-obj "color" "0x2817025" "program" particleRender))

;; (def s (js/THREE.ParticleCanvasMaterial. o))

;; (.log js/console o) ;; here is the key point: why 'modern_cljs$core$particleRender(context)' is diff ? And how to fix?
;; (.log js/console s)

(defn makeParticles
  []
  (loop [zpos -1000]
    (if (< zpos 1000)
      (do
        (let [material (js/THREE.ParticleCanvasMaterial. (js-obj "color" (getRandomColor) "program" js/particleRender)) ;; here is a deadly bug! That the modern_cljs.core.particleRender = function modern_cljs$core$particleRender(context) {...} ... The point/this is diff?
              particle (js/THREE.Particle. material)]
          (do
            ;(particle.position.x (- (* (rand 1) 1000) 500))
                                        ;(.log js/console particle.position.x)
            ;(js* "particle.position.x = 200")
            ;; (.log js/console material)
            ;; (.log js/console particle)
            (. scene add particle)))
        (recur (+ 500 zpos))))))
    ;(def Particles (conj Particles '(1 2 3)))
    ;()))

(.log js/console scene)

(makeParticles)
;; (.log js/console Particles)

;; update or render
;; (. renderer render scene camera)
(. renderer render scene camera)
