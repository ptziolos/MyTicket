import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useUsers } from "./UsersContext";
import DeleteIcon from "@mui/icons-material/Delete";
import EditIcon from "@mui/icons-material/Edit";
import AddIcon from "@mui/icons-material/Add";
import { Fab, Stack } from "@mui/material";

export default function BasicTable() {
  const { users, deleteUser } = useUsers();

  const handleEdit = () => {
    // Logic to add a user
    console.log("edit");
  };

  const handleDelete = (id) => {
    deleteUser(id);
  };

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell align="center">ID</TableCell>
            <TableCell align="center">Firstname</TableCell>
            <TableCell align="center">Lastname</TableCell>
            <TableCell align="center">Email</TableCell>
            <TableCell align="center">Roles</TableCell>
            <TableCell align="center">Tickets&nbsp;(IDs)</TableCell>
            {/* <TableCell align="center">
              Actions
            </TableCell> */}
            <TableCell align="center">
              <Fab 
                variant="extended"
                key={"add"}
                onClick={() => handleAdd(user.id)}
                aria-label="add"
                color="success"
                // size="small"
                size="medium"
                sx={{
                  borderRadius: 5,
                }}
              >
                Add
                <AddIcon />
              </Fab>
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {users.map((user) => (
            <TableRow
              key={user.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="center">{user.id}</TableCell>
              <TableCell align="center">{user.firstname}</TableCell>
              <TableCell align="center">{user.lastname}</TableCell>
              <TableCell align="center">{user.email}</TableCell>
              <TableCell align="center">
                {user.roles.map((role) => role + " ")}
              </TableCell>
              <TableCell align="center">
                {user.petitionedTickets.map((i) => i + " ")}
              </TableCell>
              <TableCell align="center" >
                <Stack direction={"row"} spacing={1} justifyContent="center">
                  <Fab
                    key={"edit"}
                    onClick={() => handleEdit(user.id)}
                    aria-label="edit"
                    color="warning"
                    size="small"
                  >
                    <EditIcon />
                  </Fab>
                  <Fab
                    key={"delete"}
                    onClick={() => handleDelete(user.id)}
                    aria-label="edit"
                    color="error"
                    size="small"
                  >
                    <DeleteIcon />
                  </Fab>  
                </Stack>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
