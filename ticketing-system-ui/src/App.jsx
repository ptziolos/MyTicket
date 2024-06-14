import NavigationBar from "./NavigationBar.jsx";
import BasicTable from "./BasicTable.jsx";
import { UserProvider } from "./UsersContext.jsx";

function App() {
  return (
    <div>
      <NavigationBar />
      <UserProvider>
        <BasicTable />
      </UserProvider>
    </div>
  );
}

export default App;
