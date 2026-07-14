# 3. ReactJS-HOL — Score Calculator App (Function Components + Styling)

**Goal:** Create a function component `CalculateScore` that accepts
`Name`, `School`, `total`, and `goal` as props, calculates a score, and
displays it — styled via an imported CSS file.

## Structure
- `src/Components/CalculateScore.js` — function component, destructured
  props, helper functions `percentToDecimal` and `calcScore`
- `src/Stylesheets/mystyle.css` — class-based styling per field
- `src/App.js` — invokes `<CalculateScore Name="Steeve" School="DNV Public School" total={284} goal={3} />`

## Run it
```bash
npm install
npm start
```
