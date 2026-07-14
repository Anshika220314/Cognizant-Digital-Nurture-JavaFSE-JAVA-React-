# 4. ReactJS-HOL — Blog App (Component Lifecycle)

**Goal:** Implement `componentDidMount()` and `componentDidCatch()`
lifecycle hooks in a class component.

## Structure
- `src/Post.js` — plain `Post` class (id, title, body)
- `src/Posts.js` — class component:
  - constructor initializes `state.posts = []`
  - `loadPosts()` fetches from `https://jsonplaceholder.typicode.com/posts`
    and stores results in state as `Post` instances
  - `componentDidMount()` calls `loadPosts()` once the component mounts
  - `render()` displays each post's title (heading) and body (paragraph)
  - `componentDidCatch(error, info)` catches rendering errors in this
    component's subtree and shows them as an alert
- `src/App.js` — renders `<Posts/>`

## Run it
```bash
npm install
npm start
```
Requires an internet connection — posts are fetched live from
jsonplaceholder.typicode.com.
