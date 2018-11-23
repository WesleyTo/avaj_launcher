#******************************************************************************#
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: wto <marvin@42.fr>                         +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/10/20 21:18:07 by wto               #+#    #+#              #
#    Updated: 2018/10/20 21:18:08 by wto              ###   ########.fr        #
#                                                                              #
#******************************************************************************#

NAME		=	avaj_launcher.simulator.Simulator
OUTDIR		=	./avaj_launcher
OUTPUT		=	simulation.txt
COMPILER	=	javac
FLAGS		=	-sourcepath
V7FLAGS		=	-source 7 -target 7
SRCFILE		=	sources.txt
RM			=	/bin/rm
RMFLAGS		=	-rf
SCENARIO	=	scenario.txt
JAVA		=	java

ifndef VERBOSE
.SILENT:
endif

all:
	find . -name *.java > $(SRCFILE)
	$(COMPILER) -d . $(FLAGS) @$(SRCFILE)

v7:
	find . -name *.java > $(SRCFILE)
	$(COMPILER) -d . $(V7FLAGS) $(FLAGS) @$(SRCFILE)

clean:
	$(RM) $(RMFLAGS) $(SRCFILE)

fclean: clean
	$(RM) $(RMFLAGS) $(OUTDIR)

run:
	$(JAVA) $(NAME) $(SCENARIO)

re: fclean all
