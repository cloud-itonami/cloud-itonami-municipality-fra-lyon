(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Lyon -- the
  TWENTY-SEVENTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara for the first
  twenty-six) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).
  Lyon is France's third-largest city but NOT its national capital
  (Paris is, and cloud-itonami-municipality-fra-paris already covers
  it) -- included on the same footing as other second/third-city
  entries in this family (Toronto, Sydney, São Paulo, Guadalajara).

  Guatemala City (muniguate.com) was attempted first this tick, but
  its official domain 301-redirected entirely to a suspicious
  lookalike domain ('munigate10.com') -- a likely domain-compromise
  situation. That redirect was NOT followed and no content from it was
  cited; the attempt was abandoned outright.

  Every entry here instead cites an OFFICIAL lyon.fr deliberation PDF
  -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an
  id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"lyon"
   [{:ordinance/id "lyon.deliberation-2021-1164-logements-sociaux"
     :ordinance/title "Approbation de la politique d'attribution des logements sociaux (Délibération 2021/1164)"
     :ordinance/municipality "lyon"
     :ordinance/country "FRA"
     :ordinance/kind :ordinance
     :ordinance/number "Délibération N.º 2021/1164"
     :ordinance/url "https://lyon.fr/blob?op=202109%2Fdelib%2F20211164.pdf"
     :ordinance/url-provenance :official-lyon-fr
     :ordinance/enacted-date "2021-09-30"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:housing}}
    {:ordinance/id "lyon.deliberation-2021-725-teletravail"
     :ordinance/title "Mise en oeuvre du dispositif pérenne de télétravail à la Ville de Lyon (Délibération 2021/725)"
     :ordinance/municipality "lyon"
     :ordinance/country "FRA"
     :ordinance/kind :ordinance
     :ordinance/number "Délibération N.º 2021/725"
     :ordinance/url "https://www.lyon.fr/blob?op=202105%2Fdelib%2F20210725.pdf"
     :ordinance/url-provenance :official-lyon-fr
     :ordinance/enacted-date "2021-05-27"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-fra-lyon Wave 0 (ADR-2607141700): "
                 (count (get catalog "lyon")) " Lyon entries seeded "
                 "with an official lyon.fr citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
