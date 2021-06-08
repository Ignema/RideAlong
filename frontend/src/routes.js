import Homepage from './components/Homepage/Homepage.svelte'
import LoginPage from './components/LoginPage/Loginpage.svelte'
import SignupPage from './components/SignupPage/Signuppage.svelte'
import Dashboard from './components/Dashboard/Dashboard.svelte'
import Readmore from './components/Readmore/Readmore.svelte'

const routes = {
    '/': Homepage,
    '/login': LoginPage,
    '/signup': SignupPage,
    '/app': Dashboard,
    '/about': Readmore
        // Catch-all
        // This is optional, but if present it must be the last
        // '*': NotFound,
}

export { routes }