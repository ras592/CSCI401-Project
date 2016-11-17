import os

user = raw_input('Enter your database user: ')
password = raw_input('Enter your database password: ')

import_base_str = "mysql -u {} -p{} FastrSale < ".format(user, password)
run_base_str = "mysql -u {} -p{} FastrSale ".format(user, password)
init_stored_procs = [
    os.path.join('.', 'stored_proc', 'create_roles.sql'),
    os.path.join('.', 'stored_proc', 'create_users.sql'),
    os.path.join('.', 'stored_proc', 'init_roles.sql'),
    os.path.join('.', 'stored_proc', 'init_users.sql')
]

init_stored_proc_names = [
    'create_roles',
    'create_users',
    'init_roles',
    'init_users'
]

other_stored_procs = [
    os.path.join('.', 'stored_proc', 'insert_user.sql'),
    os.path.join('.', 'stored_proc', 'select_roles.sql'),
    os.path.join('.', 'stored_proc', 'select_users.sql'),
    os.path.join('.', 'stored_proc', 'validate_user.sql'),
    os.path.join('.', 'stored_proc', 'get_user.sql')
]

other_stored_proc_names = [
    'select_roles',
    'select_users',
    'validate_user',
    'insert_users',
    'get_user'
]

# run create db procedure first
print "creating the database..."
os.system(import_base_str + os.path.join('.', 'stored_proc', 'create_db.sql'))
os.system(run_base_str + "-e \"call create_db()\"")

# import all init procedures
for proc in init_stored_procs:
    print "importing: ", proc
    os.system(import_base_str + proc)

# import all other procedures
for proc in other_stored_procs:
    print "importing: ", proc
    os.system(import_base_str + proc)

# call all init procedures
for proc in init_stored_proc_names:
    print "calling: ", proc
    os.system(run_base_str +  "-e \"call " + proc + "()\"")
