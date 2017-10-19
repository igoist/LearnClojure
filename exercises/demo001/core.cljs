;; create the main project namespace
(ns modern-cljs.core)

;; enable cljs to print to the JS console of the browser
(enable-console-print!)

(def mouseY 0)

(def Particles '())

(.log js/console Particles)

(defn particleRender
  [context]
  (. context beginPath)
  (. context arc 0 0 1 0 (* 2 3.14) true)
  (. context fill))

(def o (js-obj "color" "0x2817025" "program" particleRender))

(def s (js/THREE.ParticleCanvasMaterial. o))

(.log js/console o) ;; here is the key point: why 'modern_cljs$core$particleRender(context)' is diff ? And how to fix?
(.log js/console s)

(defn makeParticles
  []
  (loop [zpos -1000]
    (if (< zpos 1000)
      (do
        (let [material (js/THREE.ParticleCanvasMaterial. {:color "0x2817025" :program particleRender})]
          (.log js/console material))))
    (let [ss '234]
      (println ss))
    (def Particles (conj Particles '(1 2 3))))
  (dotimes [i 2]
    (println "hello" i))
  (do
    (println "End of make...")))


;; 1. 创建相机，并调整参数 .position.z
(def camera (js/THREE.PerspectiveCamera. 80 (/ js/window.innerWidth js/window.innerHeight) 1 4000))

(def camera.position.z 1000)

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

;; 4 & 5 body 加入 canvas，创建离子
(js/document.body.appendChild renderer.domElement)

(makeParticles)
(.log js/console Particles)
