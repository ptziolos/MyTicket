import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import BookOnlineRoundedIcon from "@mui/icons-material/BookOnlineRounded";
import { Icon } from "@mui/material";

export default function NavigationBar() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" sx={{ backgroundColor: "black" }}>
        <Toolbar>
          <Icon
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <BookOnlineRoundedIcon />
          </Icon>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            MyTicket
          </Typography>
          <Button color="inherit">Tickets</Button>
          <Button color="inherit">Users</Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
