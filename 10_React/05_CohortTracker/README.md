# 5. ReactJS-HOL — Cohort Tracker (CSS Modules & Inline Styles)

**Goal:** Style an existing React component using a CSS Module.

The Cognizant Academy team needs a dashboard showing ongoing/completed
cohort details. The base app (`App.js`, `Cohort.js`, unstyled
`CohortDetails.js`) was provided as a starter project — recovered here
from the embedded attachment in the original hands-on document — and
this submission completes the styling task on top of it.

## What was added
- `src/CohortDetails.module.css` — CSS Module with:
  - `.box` — 300px wide, inline-block, 10px margin, 10px top/bottom +
    20px left/right padding, 1px black border, 10px border radius
  - `dt` tag selector — font-weight 500
  - `.ongoing` / `.other` — green vs. blue heading color
- `src/CohortDetails.js` — imports the module, applies `.box` to the
  container div, and conditionally applies `.ongoing` (green) or
  `.other` (blue) to the `<h3>` based on `cohort.currentStatus`

## Run it
```bash
npm install
npm start
```
Each cohort renders as a bordered, rounded card; cards for cohorts with
status "Ongoing" show a green heading, everything else shows blue.
