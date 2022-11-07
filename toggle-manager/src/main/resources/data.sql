INSERT INTO tla (name) VALUES ('SIB');
INSERT INTO toggle (name, status, master) VALUES ('sib.toggle.long.name', FALSE, TRUE);
INSERT INTO toggle_tags (Toggle_name, tags) VALUES ('sib.toggle.long.name', 'long feature');
INSERT INTO tla_toggles (Tla_name, toggles_name) VALUES ('SIB', 'sib.toggle.long.name');

INSERT INTO tla (name) VALUES ('SPB');
INSERT INTO toggle (name, status, master) VALUES ('spb.toggle.long.name', FALSE, TRUE);
INSERT INTO toggle (name, status, master) VALUES ('spb.toggle.short.name', TRUE, FALSE);
INSERT INTO toggle_tags (Toggle_name, tags) VALUES ('spb.toggle.long.name', 'long feature');
INSERT INTO toggle_tags (Toggle_name, tags) VALUES ('spb.toggle.short.name', 'short feature');
INSERT INTO tla_toggles (Tla_name, toggles_name) VALUES ('SPB', 'spb.toggle.long.name');
INSERT INTO tla_toggles (Tla_name, toggles_name) VALUES ('SPB', 'spb.toggle.short.name');

INSERT INTO tla (name) VALUES ('BOA');
INSERT INTO toggle (name, master) VALUES ('boa.toggle.middle.name', TRUE);
INSERT INTO tla_toggles (Tla_name, toggles_name) VALUES ('BOA', 'boa.toggle.middle.name');