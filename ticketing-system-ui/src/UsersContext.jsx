import { createContext, useContext, useReducer, useEffect } from "react";

const BASE_URL = "http://localhost:8000";

const UserContext = createContext();

const initialState = {
  isLoading: false,
  users: [],
};

const reducer = (state, action) => {
  switch (action.type) {
    case "loading":
      return { ...state, isLoading: true };
    case "load/users":
      return {
        ...state,
        isLoading: false,
        users: action.payload.sort((a, b) => (a.id > b.id ? -1 : 1)),
      };
    case "create/user":
      return {
        ...state,
        isLoading: false,
        users: [...state.users, action.payload].sort((a, b) =>
          a.id > b.id ? -1 : 1
        ),
      };
    case "edit/user":
      return {
        ...state,
        isLoading: false,
        users: action.payload.sort((a, b) => (a.id > b.id ? -1 : 1)),
      };
    case "delete/user":
      return {
        ...state,
        isLoading: false,
        users: state.users.filter((user) => user.id !== action.payload),
      };
    case "rejected":
      return {
        ...state,
        isLoading: false,
        error: action.payload,
      };
    default:
      throw new Error("Unknown action type");
  }
};

function UserProvider({ children }) {
  const [{ users }, dispatch] = useReducer(reducer, initialState);

  useEffect(function () {
    dispatch({ type: "loading" });
    async function fetchUsers() {
      try {
        const result = await fetch(`${BASE_URL}/users`);
        const data = await result.json();
        dispatch({ type: "load/users", payload: data });
      } catch {
        dispatch({
          type: "rejected",
          payload: "There was an error loading the ID Filters",
        });
      }
    }

    fetchUsers();
  }, []);

  async function createUser(newUser) {
    dispatch({ type: "loading" });
    try {
      const res = await fetch(`${BASE_URL}/users`, {
        method: "POST",
        body: JSON.stringify(newUser),
        headers: {
          "Content-Type": "application/json",
        },
      });
      const data = await res.json();
      dispatch({ type: "create/user", payload: data });
    } catch {
      dispatch({
        type: "rejected",
        payload: "There was an error creating the city...",
      });
    }
  }

  async function deleteUser(id) {
    dispatch({ type: "loading" });
    try {
      await fetch(`${BASE_URL}/users/${id}`, {
        method: "DELETE",
      });
      dispatch({ type: "delete/user", payload: id });
    } catch {
      dispatch({
        type: "rejected",
        payload: "There was an error deleting the city...",
      });
    }
  }

  return (
    <UserContext.Provider
      value={{
        users,
        createUser,
        deleteUser,
      }}
    >
      {children}
    </UserContext.Provider>
  );
}

function useUsers() {
  const context = useContext(UserContext);
  if (context === undefined) {
    throw new Error("User context was used outside the UserProvider");
  }
  return context;
}

export { UserProvider, useUsers };
