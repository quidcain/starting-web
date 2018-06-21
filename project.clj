(defproject starting-web "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler starting-web.core/app}
  :main starting-web.core
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [ring/ring-devel "1.6.3"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.6.1"]]
  :profiles
  {:dev {:dependencies [[ring/ring-mock "0.3.2"]
                        [cheshire "5.8.0"]]}})
